package com.snapdeal.dis.services.dao.aao;

import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.WritePolicy;
import com.snapdeal.dis.services.dao.SummaryDao;
import com.snapdeal.dis.services.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;


@Component("summaryAao")
public class SummaryAao implements SummaryDao {

	@Autowired
	@Qualifier("aerospikeManager")
	private AerospikeManager aerospikeManager;
	private String summarySet;
	private String summaryNamespace;
	private static String KEY_BIN_NAME = "k";
	private WritePolicy writePolicy = null;
	private static Logger LOG = LoggerFactory.getLogger(SummaryAao.class);

	public SummaryAao() {
	}

	@PostConstruct
	private void init() {
		this.summarySet = aerospikeManager.getAerospikeProperties().getProperty(Constants.AEROSPIKE_SUMMARY_SETNAME);
		this.summaryNamespace = aerospikeManager.getAerospikeProperties()
				.getProperty(Constants.AEROSPIKE_SUMMARY_NAMESPACE);
		setWritePolicy();
	}

	private void setWritePolicy() {
		writePolicy = new WritePolicy();
		writePolicy.sendKey = true;
	}

	@Override
	public Long get(String strKey, String bin) {
		Long value = 0l;
		Key key = createKey(strKey);
		Record record = aerospikeManager.getAerospikeClient().get(null, key);
		if (record != null) {
			value = record.getLong(bin);
		}
		return value;
	}

	private Key createKey(String strKey) {
		return new Key(summaryNamespace, summarySet, strKey);
	}

	@Override
	public Map<String, Object> getAllFields(String guid) {
		Map<String, Object> allFields = null;

		Policy policy = new Policy();
		Record record = aerospikeManager.getAerospikeClient().get(policy, createKey(guid));

		if (record != null) {
			allFields = record.bins;
		}

		return allFields;
	}

}
