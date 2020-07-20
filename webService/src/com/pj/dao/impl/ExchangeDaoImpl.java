package com.pj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pj.dao.ExchangeDao;
import com.pj.entity.Exchange;
import com.pj.entity.Goods;
import com.pj.entity.User;
import com.pj.util.C3P0Util;

public class ExchangeDaoImpl implements ExchangeDao{

	@Override
	public Exchange Add(Exchange exchange) {
		// TODO Auto-generated method stub
		try {
			Connection connection=C3P0Util.getConnection();
			String sql="insert into exchanges(buyer_id,seller_id,goods_id,num ,money )values(?,?,?,?,?)";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, exchange.getBuyerId());
			ps.setInt(2, exchange.getSellerId());
			ps.setInt(3, exchange.getGoodsId());
			ps.setInt(4, exchange.getNum());
			ps.setInt(5, exchange.getMoney());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return exchange;
	}

	@Override
	public int Delete(int echangeId) {
		// TODO Auto-generated method stub
		int deleResult=0;
		try {
			Connection connection=C3P0Util.getConnection();
			String sql="delete from exchanges where exchange_id=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, echangeId);
			deleResult=ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleResult;
	}

	@Override
	public Exchange Modify(Exchange exchange) {
		// TODO Auto-generated method stub
		try {
			Connection connection=C3P0Util.getConnection();
			String sql="update exchanges set buyer_id=?,seller_type=?,goods_id=?,num=?,money where exchange_id=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, exchange.getBuyerId());
			ps.setInt(2, exchange.getSellerId());
			ps.setInt(3, exchange.getGoodsId());
			ps.setInt(4, exchange.getNum());
			ps.setInt(5, exchange.getMoney());
			ps.setInt(6, exchange.getExchangeId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exchange;
	}

	@Override
	public List<Exchange> queryAll() {
		// TODO Auto-generated method stub
		List<Exchange> list=new ArrayList<Exchange>();
		try {
			Connection connection=C3P0Util.getConnection();
			PreparedStatement ps=connection.prepareStatement("select user.user_name as seller,temp2.goods,temp2.buyer,temp2.num,temp2.money " +
					"from user,(select goods.goods_name as goods,temp.buyer,temp.num,temp.money,temp.seller_id " +
								"from goods,(select user_name as buyer,num,money,goods_id,seller_id from user,exchanges where user.user_id=exchanges.buyer_id) as temp " +
								"where goods.goods_id=temp.goods_id) as temp2 " +
					"where user.user_id=temp2.seller_id");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				list.add(new Exchange(rs.getInt("temp2.num"),rs.getInt("temp2.money"),rs.getString("temp2.buyer"),rs.getString("seller"),rs.getString("temp2.goods")));
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
	public List<Exchange> queryAllByUserName(String UserName) {
		// TODO Auto-generated method stub
		List<Exchange> list=new ArrayList<Exchange>();
		try {
			Connection connection=C3P0Util.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from (select user.user_name as seller,temp2.goods as goods,temp2.buyer as buyer,temp2.num as num,temp2.money as money from user,(select goods.goods_name as goods,temp.buyer,temp.num,temp.money,temp.seller_id from goods,(select user_name as buyer,num,money,goods_id,seller_id from user,exchanges where user.user_id=exchanges.buyer_id) as temp where goods.goods_id=temp.goods_id) as temp2 where user.user_id=temp2.seller_id) as temp3 where temp3.seller=? or temp3.buyer=?");
			ps.setString(1, UserName);
			ps.setString(2, UserName);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				list.add(new Exchange(rs.getInt("temp3.num"),rs.getInt("temp3.money"),rs.getString("temp3.buyer"),rs.getString("temp3.seller"),rs.getString("temp3.goods")));
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
	public Exchange MostExchangeByUserId(int userId,String userType) {
		// TODO Auto-generated method stub
		Exchange exchangeResult=null;
		try {
			Connection connection=C3P0Util.getConnection();
			String sql="";
			if(userType.equals("Âò¼Ò")){
				sql=" select goods.goods_name,temp5.summoney,temp5.sumnum from goods, ( select temp3.goods goods,temp3.summoney summoney,temp3.sumnum from (select temp.buyer_id buyer,temp.goods_id goods,sum(temp.num) sumnum,sum(temp.money) summoney from (select * from exchanges where buyer_id=?) as temp group by goods_id) as temp3,( select max(temp2.sumnum) maxnum from (select temp.buyer_id buyer,temp.goods_id goods,sum(temp.num) sumnum,sum(temp.money) summoney from (select * from exchanges where buyer_id=?) as temp group by goods_id) as temp2)as temp4 where temp3.sumnum=temp4.maxnum) as temp5 where goods.goods_id=temp5.goods";
			}
			if(userType.equals("ÉÌ¼Ò")){
				sql="select goods.goods_name,temp5.summoney,temp5.sumnum from goods,(select temp3.goods goods,temp3.summoney summoney,temp3.sumnum from (select temp.seller_id seller,temp.goods_id goods,sum(temp.num) sumnum,sum(temp.money) summoney from (select * from exchanges where seller_id=?) as temp group by goods_id) as temp3,( select max(temp2.sumnum) maxnum from (select temp.seller_id seller,temp.goods_id goods,sum(temp.num) sumnum,sum(temp.money) summoney from (select * from exchanges where seller_id=?) as temp group by goods_id) as temp2)as temp4 where temp3.sumnum=temp4.maxnum) as temp5 where goods.goods_id=temp5.goods";
			}
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, userId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				exchangeResult=new Exchange(rs.getInt("temp5.sumnum"),rs.getInt("temp5.summoney"),rs.getString("goods.goods_name"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exchangeResult;
	}

	@Override
	public Exchange MostGoods() {
		// TODO Auto-generated method stub
		Exchange result=null;
		try {
			Connection connection = C3P0Util.getConnection();
			PreparedStatement ps=connection.prepareStatement("select goods.goods_name from goods,(select temp2.goods_id goods from(select sum(num) sumnum,goods_id from exchanges group by goods_id) as temp2,(select max(temp.sumnum) maxnum from (select sum(num) sumnum,goods_id from exchanges group by goods_id) as temp) as temp3 where temp2.sumnum=temp3.maxnum)as temp4 where goods.goods_id=temp4.goods");
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				result=new Exchange(rs.getString("goods.goods_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
