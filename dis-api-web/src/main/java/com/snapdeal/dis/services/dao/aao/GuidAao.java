package com.snapdeal.dis.services.dao.aao;

import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.policy.Policy;
import com.snapdeal.dis.services.dao.GuidDao;
import com.snapdeal.dis.services.util.Constants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("guidAao")
public class GuidAao implements GuidDao {

	private static Logger LOG = Logger.getLogger(GuidAao.class);

	private final String GUID_BIN_NAME = "G";
	private final String EMAIL_BIN_NAME = "E";
	private final String TIMESTAMP_BIN_NAME = "T";
	private AerospikeManager aerospikeManager;
	private String guidMapSetName;

   @Autowired
	public GuidAao(@Qualifier("aerospikeManager")AerospikeManager aerospikeManager){
		this.aerospikeManager = aerospikeManager;
	}
   
	@PostConstruct
	public void postInit(){
		this.guidMapSetName = aerospikeManager.getAerospikeProperties()
				.getProperty(Constants.AEROSPIKE_GUIDMAP_SETNAME);
	}

	private Key createKey(String strKey) {
		return new Key(aerospikeManager.getAerospikeProperties().getProperty(Constants.AEROSPIKE_GUIDMAP_NAMESPACE),
				guidMapSetName, strKey);
	}


	@Override
	public String getGuid(String key) {
		Policy policy = new Policy();
		Record guidBin = aerospikeManager.getAerospikeClient().get(policy, createKey(key), GUID_BIN_NAME);
		if (guidBin != null && guidBin.getString(GUID_BIN_NAME) != null)
			return guidBin.getString(GUID_BIN_NAME);
		else
			return null;
	}

}
