package com.sys.ssm.system.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSONObject;
import com.sys.ssm.system.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Jwt工具
 * @author huhao
 *
 */
public class Jwt {
	
	private static Jwt jwt =new Jwt();
	
	private Jwt(){
		
	}
	
	public static Jwt getInstance (){
		return jwt;
	}
	
	
	
	/**
	 * 创建jwt
	 * @param id
	 * @param subject
	 * @param ttlMillis 过期的时间长度
	 * @return
	 */
	public String createJwt(String id,String subject,long ttlMillis){
		//指定签名的时候指定的签名算法
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		
		//生成jwt的时间
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		
		//创建payload的私有声明（根据特定的业务需要添加
		//如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的
		Map<String,Object> claims = new HashMap<String,Object>();
		claims.put("uId", "123");
		claims.put("loginName", "admin");
		claims.put("realName", "GM");
		
		//生成签名的时候使用的秘钥secret,这个方法本地封装了的
		//一般可以从本地配置文件中读取，切记这个秘钥不能外露哦。
		//它就是你服务端的私钥，在任何场景都不应该流露出去。
		//一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。
		SecretKey key = generalKey();
		
		//下面就是在为payload添加各种标准声明和私有声明了
		//这里其实就是new一个JwtBuilder，设置jwt的body
		JwtBuilder builder = Jwts.builder()
				//如果有私有声明，一定要先设置这个自己创建的私有的声明
				//这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
				.setClaims(claims)
				//设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值
				//主要用来作为一次性token,从而回避重放攻击。
				.setId(id)
				//iat: jwt的签发时间
				.setIssuedAt(now)
				//sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串
				//可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
				.setSubject(subject)
				//设置签名使用的签名算法和签名使用的秘钥
				.signWith(signatureAlgorithm, key);
		
		//设置过期时间
		if(ttlMillis>0){
			 long expMillis = nowMillis + ttlMillis;
			 Date exp = new Date(expMillis);
			 builder.setExpiration(exp);
		}
		
		//就开始压缩为xxxxxxxxxxxxxx.xxxxxxxxxxxxxxx.xxxxxxxxxxxxx这样的jwt
		return builder.compact(); 
	}
	
	
	/**
	 * 解密jwt并返回私有声明
	 * @param Jwt
	 * @return
	 */
	public Claims parseJWT(String Jwt){
		//签名秘钥，要和生成的签名的秘钥一模一样
		SecretKey key = generalKey();
		
		//得到DefaultJwtParser
		Claims claims = Jwts.parser()
				//设置签名的秘钥
				.setSigningKey(key)
				//设置需要解析的jwt
				.parseClaimsJws(Jwt).getBody();
		
		return claims;
		
	}
	
	
	public SecretKey generalKey(){
		//本地配置文件中加密的密文
		String stringKey = Constant.JWT_SECRET;
		//本地的密码解码
		byte[] encodedKey = Base64.decodeBase64(stringKey);
		
		//根据给定的字节数组使用AES加密算法构造一个密钥
		//使用 encodedKey中的始于且包含 0 到前 leng 个字节这是当然是所有。
		SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
		
		return key;
	}
	
	
	public static String generalSubject(User user){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("userId", user.getId());
		return jsonObject.toJSONString();
	}
	
	
	/**
	 * 测试
	 * utils Test 
	 * @throws InterruptedException 
	 */
	public static void main(String args[]) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//登陆
		Jwt jwt = new Jwt();
		String token2 = jwt.createJwt("2", "{id:200,name:xiaohong2}", 2000);
		System.out.println(token2);
		Claims c2 = jwt.parseJWT(token2);
 		System.out.println(c2.getSubject());
 		
 		//logout
 		Jwt jwt2 = new Jwt();
 		
 		
 		
// 		System.out.println(c2_.getSubject());

	}
	
	

}
