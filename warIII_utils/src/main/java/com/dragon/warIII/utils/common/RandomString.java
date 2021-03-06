package com.dragon.warIII.utils.common;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

/**
 * @description 功能描述: 生成随机字符串(三种方式)
 * @author 作 者: L.D
 * @createdate 建立日期：2016-8-26
 * @projectname 项目名称: warIII_utils
 * @packageclass 包及类名: com.dragon.warIII.utils.common RandomString.java
 */
public class RandomString {

	/**
	 * <p>
	 * 1.生成的字符串每个位置都有可能是str中的一个字母或数字
	 * 1.1.招商银行秘钥(秘钥长度16位,要求包含数字和大、小写字母)
	 * </p>
	 *
	 */
	public static String getRandomString(int length) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * <p>
	 * 2.org.apache.commons.lang包下有一个RandomStringUtils类,其中有一个
	 * randomAlphanumeric(int length)函数，可以随机生成一个长度为length的字符串。
	 * </p>
	 */
	public static String getRandomString2(int length) {
		String num = RandomStringUtils.randomAlphanumeric(10);
		return num;
	}

	/**
	 * <p>
	 * 3.可以指定某个位置是a-z、A-Z或是0-9，需要导入的包是 import
	 * java.util.Random(可以指定字符串的某个位置是什么范围的值)
	 * </p>
	 */
	public static String getRandomString3(int length) {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(3);
			long result = 0;
			switch (number) {
			case 0:
				result = Math.round(Math.random() * 25 + 65);
				sb.append(String.valueOf((char) result));
				break;
			case 1:
				result = Math.round(Math.random() * 25 + 97);
				sb.append(String.valueOf((char) result));
				break;
			case 2:
				sb.append(String.valueOf(new Random().nextInt(10)));
				break;
			}

		}
		return sb.toString();
	}
}
