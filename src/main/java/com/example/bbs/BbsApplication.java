package com.example.bbs;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BbsApplication {

	public static void main(String[] args) {
		// .envファイルを読み込む（プロジェクトルートに配置）
		// dotenv-javaはデフォルトでプロジェクトルートから.envファイルを探す
		Dotenv dotenv = Dotenv.configure()
				.ignoreIfMissing()
				.load();

		// .envファイルの値をシステムプロパティとして設定
		// Spring Bootの${DB_USERNAME:default_user}形式はSystem.getProperty()を参照する
		dotenv.entries().forEach(entry -> {
			System.setProperty(entry.getKey(), entry.getValue());
		});

		SpringApplication.run(BbsApplication.class, args);
	}

}
