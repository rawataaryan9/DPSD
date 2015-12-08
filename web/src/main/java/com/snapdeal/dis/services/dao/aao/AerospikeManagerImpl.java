package com.snapdeal.dis.services.dao.aao;

import com.aerospike.client.AerospikeClient;
import com.snapdeal.dis.services.util.Constants;
import com.snapdeal.dis.services.util.Utils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;


@Component("aerospikeManager")
public class AerospikeManagerImpl implements AerospikeManager{

    private static String AEROSPIKE_PROPERTIES_PATH = "conf/aerospike.properties";
    private AerospikeClient aerospikeClient;
    private Properties aerospikeProperties;

    @PostConstruct
    public void init(){
        this.aerospikeProperties = Utils.loadPropertiesFromClassPath(AEROSPIKE_PROPERTIES_PATH);
        this.aerospikeClient = new AerospikeClient(null, aerospikeProperties.getProperty("aerospike.host"),
                Integer.valueOf(aerospikeProperties.getProperty("aerospike.port")));
    }

    public AerospikeClient getAerospikeClient() {
        return aerospikeClient;
    }

    public Properties getAerospikeProperties(){
        return aerospikeProperties;
    }

    public String getNamespace(){
        return aerospikeProperties.getProperty(Constants.AEROSPIKE_NAMESPACE);
    }

}
