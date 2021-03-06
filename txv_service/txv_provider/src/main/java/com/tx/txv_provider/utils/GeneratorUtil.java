package com.tx.txv_provider.utils;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneratorUtil {

	public static void main(String[] args) throws Exception {
		try {
			GeneratorUtil generatorSqlmap = new GeneratorUtil();
			generatorSqlmap.generator();
			System.out.println("成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}



	public void generator() throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		// 指定 逆向工程配置文件
		String filePath = GeneratorUtil.class.getResource("/generatorConfig.xml").getFile();
		File configFile=new File(filePath);
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);

	}



}
