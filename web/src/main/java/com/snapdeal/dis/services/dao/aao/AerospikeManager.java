package com.snapdeal.dis.services.dao.aao;

import com.aerospike.client.AerospikeClient;

import java.util.Properties;

public interface AerospikeManager {
    AerospikeClient getAerospikeClient();
    Properties getAerospikeProperties();
}
