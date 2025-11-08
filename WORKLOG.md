# 作業ログ

このファイルには、プロジェクトで実施した作業内容を記録します。

---

## 2025-11-04

### 作業内容
- プロジェクト立ち上げ
- pom.xmlにlombok追加

### 備考
- [その他のメモや注意事項]

---

## 2025-11-05

### 作業内容
- githubにリポジトリ作成

### 備考
- [その他のメモや注意事項]

---

## 2025-11-07

### 作業内容
- pom.xmlに依存関係の追加
- application.propertiesに設定追加
- データベース作成



### 備考
- データベースの作成
    - `psql -U postgres -d postgres -c "CREATE DATABASE board;"`
- データベースの接続
    - `psql -U postgres -d board`
- データベースのネームとパスを環境変数で設定
    - `application.properties`には環境変数を設定
    - 実際のネームとパスは`.env`に記載（ディレクトリは`pom.xml`と同じ場所）
    - `.env`は`.gitignore`に含める
- 初回localhostアクセス時に `src/main/resources/templates/` ディレクトリが存在しないと、Thymeleafがテンプレートを見つけられず警告が出ます
    - `mkdir -p src/main/resources/templates`

- spring-boot-starter-webのが不足すると、Webサーバー（Tomcat）が起動しない






---

## テンプレート

以下の形式で記録してください：

```markdown
## YYYY-MM-DD

### 作業内容
- [実施した作業を箇条書きで記録]

### 実施した変更
- [変更したファイルや機能]

### 問題・課題
- [発生した問題や課題]

### 備考
- [その他のメモ]
```

