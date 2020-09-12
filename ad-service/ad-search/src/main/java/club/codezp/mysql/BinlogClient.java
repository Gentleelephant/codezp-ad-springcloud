package club.codezp.mysql;


import club.codezp.mysql.listener.AggregationListener;
import com.github.shyiko.mysql.binlog.BinaryLogClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 *  BinLog的Client
 */
@Slf4j
@Component
public class BinlogClient{

    private BinaryLogClient client;

    private final BinlogConfig config;
    private final AggregationListener listener;

    @Autowired
    public BinlogClient(BinlogConfig config, AggregationListener listener) {
        this.config = config;
        this.listener = listener;
    }

    /**
     * 实现监听和启动
     */
    public void connect() {

        new Thread(() -> {
            client = new BinaryLogClient(
                    config.getHost(),
                    config.getPort(),
                    config.getUsername(),
                    config.getPassword()
            );

            if (!StringUtils.isEmpty(config.getBinlogName()) &&
                    !config.getPosition().equals(-1L)) {
                client.setBinlogFilename(config.getBinlogName());
                client.setBinlogPosition(config.getPosition());
            }

            client.registerEventListener(listener);

            try {
                log.info("connecting to mysql start");
                client.connect();
                log.info("connecting to mysql done");
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }).start();
    }

    public void close() {
        try {
            client.disconnect();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

//    @Override
//    public void run() {
//        client = new BinaryLogClient(
//                config.getHost(),
//                config.getPort(),
//                config.getUsername(),
//                config.getPassword()
//        );
//
//        if (!StringUtils.isEmpty(config.getBinlogName()) &&
//                !config.getPosition().equals(-1L)) {
//            client.setBinlogFilename(config.getBinlogName());
//            client.setBinlogPosition(config.getPosition());
//        }
//
//        client.registerEventListener(listener);
//
//        try {
//            log.info("connecting to mysql start");
//            client.connect();
//            log.info("connecting to mysql done");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
}
