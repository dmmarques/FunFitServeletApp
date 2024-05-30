package com.funfit.service;

import java.util.List;

import com.funfit.bean.Batch;
import com.funfit.dao.BatchDao;

public class BatchService {
	
	BatchDao batchDao = new BatchDao();
	
	public String addBatch(Batch batch) {
		if(batchDao.addBatch(batch)>0) {
			return "Created new Batch!";
		}else {
			return "Error Creating Batch ...";
		}
	}
	
	public List<Batch> fetchAllBatches(){
		return batchDao.fetchAllBatches();
	}
	
	public String deleteBatch(String bid) {
		if(batchDao.deleteBatch(bid)>0) {
			return "Deleted Batch!";
		}else {
			return "Error Deleting Batch ...";
		}
	}

}
