package com.funfit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.funfit.bean.Batch;
import com.funfit.config.DbConfig;

public class BatchDao {
	
	public int addBatch(Batch batch) {
		try {
			Connection con = DbConfig.getDbConnection();
			PreparedStatement query = con.prepareStatement("insert into batch(typeofbatch,time) values(?,?)");
			query.setString(1, batch.getTypeofbatch());
			query.setString(2, batch.getTime());
			return query.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}

	public List<Batch> fetchAllBatches() {
		List<Batch> batchList = new ArrayList<>();
		
		try {
			Connection con = DbConfig.getDbConnection();
			PreparedStatement query = con.prepareStatement("select * from batch");
			ResultSet result = query.executeQuery();
			
			while(result.next()) {
				Batch b = new Batch();
				b.setBid(result.getInt(1));
				b.setTypeofbatch(result.getString(2));
				b.setTime(result.getString(3));
				batchList.add(b);
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return batchList;
	}
	
	public int deleteBatch(String id) {
		try {
			Connection con = DbConfig.getDbConnection();
			PreparedStatement query = con.prepareStatement("delete from batch where bid=?");
			System.out.print(Integer.valueOf(id));
			query.setInt(1, Integer.valueOf(id));
			return query.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
}
