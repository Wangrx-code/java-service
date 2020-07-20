package com.pj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pj.dao.OftenGoodsDao;
import com.pj.entity.OftenGoods;
import com.pj.util.C3P0Util;

public class OftenGoodsDaoImpl implements OftenGoodsDao{

	@Override
	public List<OftenGoods> queryAll() {
		// TODO Auto-generated method stub
		List<OftenGoods> list=new ArrayList<OftenGoods>();
		try {
			Connection connection=C3P0Util.getConnection();
			PreparedStatement ps=connection.prepareStatement("select oftengoods_id,oftengoods_name,oftengoods_price from oftengoods");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				list.add(new OftenGoods(rs.getInt("oftengoods_id"),rs.getString("oftengoods_name"),rs.getInt("oftengoods_price")));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
