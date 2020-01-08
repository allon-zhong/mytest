package com.zel.mytest.learning.zookeeper.api;

import com.zel.mytest.learning.zookeeper.lock.DistributedLockByZookeeper;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Distributed lock test api
 * <p/>
 * Created in 2018.11.12
 * <p/>
 *
 * @author Liaozihong
 */
@RestController
public class DistributedLockTestApi {
    /**
     * The Distributed lock by zookeeper.
     */
    @Autowired
    DistributedLockByZookeeper distributedLockByZookeeper;
    private final static String PATH = "testv3";

    /**
     * Gets lock 1.
     *
     * @return the lock 1
     */
    @GetMapping("/lock1")
    public String getLock1() {
        Boolean flag = false;
        distributedLockByZookeeper.acquireDistributedLock(PATH);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
        }
        flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
        if (flag) {
            return "释放锁资源成功!";
        }
        return "释放锁资源失败";
    }

   /* *//**
     * Gets lock 2.
     *
     * @return the lock 2
     *//*
    @GetMapping("/lock2")
    @ApiOperation(value = "获取分布式锁", notes = "获取分布式锁，获取到的期间，其他请求被阻塞，等待上一个释放锁资源",
            response = ApiResult.class)
    public ApiResult getLock2() {
        Boolean flag;
        distributedLockByZookeeper.acquireDistributedLock(PATH);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
        }
        flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
        if (flag) {
            return ApiResult.prepare().success("释放锁资源成功!");
        }
        return ApiResult.prepare().error(false, 500, "释放锁资源失败");
    }*/
    @GetMapping("/testWatch")
    public String testWatch() throws Exception {
         String path = "/zk-book/nodecache";
         CuratorFramework client = CuratorFrameworkFactory.builder().connectString("192.168.58.42:2181")
                .sessionTimeoutMs(60000)
                .connectionTimeoutMs(15000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();
        client.start();
         client.create()
                    .creatingParentContainersIfNeeded()
                    .withMode(CreateMode.EPHEMERAL)
                    .forPath(path,"init".getBytes());
        NodeCache cache = new NodeCache(client,path,false);
        //使用start方法开启缓存,默认是false，如果设置为true，那么NodeCache在第一次启动的时候就会立刻从ZooKeeper上读取该节点的数据内容，并保存在Cache中
        cache.start(true);
        cache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                ChildData currentData = cache.getCurrentData();
                String data = new String(currentData.getData()) ;
                System.out.println("我监听到了节点数据变化!数据为:"+data);
            }
        });
        client.setData().forPath(path,"modify".getBytes());
        cache.close();
        client.close();
        return "";
    }

}
