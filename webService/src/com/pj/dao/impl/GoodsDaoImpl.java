package com.pj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pj.dao.GoodsDao;
import com.pj.entity.Goods;
import com.pj.entity.User;
import com.pj.util.C3P0Util;

public class GoodsDaoImpl implements GoodsDao{

	@Override
	public Goods Add(Goods goods) {
		// TODO Auto-generated method stub
		try {
			Connection connection=C3P0Util.getConnection();
			String sql="insert into goods (goods_name,goods_price,goods_type,is_sale,create_time)values(?,?,?,?,now())";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, goods.getGoodsName());
			ps.setInt(2, goods.getGoodsPrice());
			ps.setString(3, goods.getGoodsType());
			ps.setString(4, goods.getIsSale());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goods;
	}

	@Override
	public Goods Modify(Goods goods) {
		// TODO Auto-generated method stub
		try {
			Connection connection=C3P0Util.getConnection();
			String sql="update goods set goods_name=?,goods_type=?,goods_price=?,is_sale=? where goods_id=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, goods.getGoodsName());
			ps.setString(2, goods.getGoodsType());
			ps.setInt(3, goods.getGoodsPrice());
			ps.setString(4, goods.getIsSale());
			ps.setInt(5, goods.getGoodsId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goods;
	}

	
	@Override
	public List<Goods> queryAll() {
		// TODO Auto-generated method stub
		List<Goods> list=new ArrayList<Goods>();
		try {
			Connection connection=C3P0Util.getConnection();
			String sql="select goods_id,goods_name,goods_price,goods_type,is_sale from goods";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				list.add(new Goods(rs.getInt("goods_price"),
						rs.getString("goods_name"),
						rs.getInt("goods_price"),
						rs.getString("goods_type"),
						rs.getString("is_sale")));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Goods> queryByType(String goodsType) {
		// TODO Auto-generated method stub
		List<Goods> list = new ArrayList<Goods>();
		try {
			Connection connection =C3P0Util.getConnection();
			String sql="select goods_name,goods_price,goods_type,is_sale from goods where goods_type=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, goodsType);
			System.out.println(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println(rs.next());
			while(rs.next()){
				//构建对象，添加到集合中
				list.add(new Goods(rs.getString("goods_name"),rs.getInt("goods_price"),rs.getString("goods_type"),rs.getString("is_sale")));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		int deleResult=0;
		try {
			Connection connection=C3P0Util.getConnection();
			String sql="delete from goods where goods_id=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, id);
			deleResult=ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleResult;
	}

	@Override
	public Goods queryByName(String goodsName) {
		// TODO Auto-generated method stub
		Goods goodsRsult=null;
		try {
			Connection connection = C3P0Util.getConnection();
			String sql="select goods_id, goods_price from goods where goods_name=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, goodsName);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				goodsRsult=new Goods();
				goodsRsult.setGoodsId(rs.getInt("goods_id"));
				goodsRsult.setGoodsPrice(rs.getInt("goods_price"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return goodsRsult;
	}

}
