# 作業ログ

このファイルには、プロジェクトで実施した作業内容を記録します。

---

## 2025-11-04

### 作業内容

- プロジェクト立ち上げ
- pom.xml に lombok 追加

### 備考

- [その他のメモや注意事項]

---

## 2025-11-05

### 作業内容

- github にリポジトリ作成

### 備考

- [その他のメモや注意事項]

---

## 2025-11-07

### 作業内容

- pom.xml に依存関係の追加
- application.properties に設定追加
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
- 初回 localhost アクセス時に `src/main/resources/templates/` ディレクトリが存在しないと、Thymeleaf がテンプレートを見つけられず警告が出ます

  - `mkdir -p src/main/resources/templates`

- spring-boot-starter-web のが不足すると、Web サーバー（Tomcat）が起動しない

---

## 2025-11-08

### 作業内容

- Modal の作成 `Post.java`
- Repository の作成 `PostRepository.java`
- Service の作成 `PostService.java`
- Contoroller の作成 `PostController.java`

### 備考

- .env ファイルの配置場所：プロジェクトルート（pom.xml と同じディレクトリ）
- `BbsApplication.java`にアプリケーション起動時に.env ファイルを読み込み、環境変数として設定するコードを追加します。

---

## 2025-11-09 以降

### 作業内容

- `PostController.java`の拡張（CRUD 操作の実装）
- `Post.java`の拡張（createdAt, updatedAt フィールドの追加、自動タイムスタンプ設定）
- `PostService.java`の実装（CRUD メソッドの実装）
- Thymeleaf テンプレートの作成
- レイアウトテンプレートの作成・修正
- `README.md`の更新

### 実施した変更

#### Controller 層

- `PostController.java`
  - 投稿一覧表示（`GET /posts`）
  - 投稿詳細表示（`GET /posts/{id}`）
  - 新規投稿フォーム（`GET /posts/new`）
  - 投稿作成（`POST /posts`）
  - 投稿編集フォーム（`GET /posts/{id}/edit`）
  - 投稿更新（`POST /posts/{id}/edit`）
  - 投稿削除（`POST /posts/{id}/delete`）

#### Model 層

- `Post.java`
  - `createdAt`、`updatedAt`フィールドの追加
  - `@PrePersist`、`@PreUpdate`アノテーションによる自動タイムスタンプ設定

#### Service 層

- `PostService.java`
  - `findAll()` - 全投稿取得
  - `findById()` - ID による投稿取得
  - `save()` - 投稿の保存
  - `deleteById()` - ID による投稿削除

#### テンプレート

- `src/main/resources/templates/posts/list.html` - 投稿一覧画面（新規作成）
  - テーブル形式での投稿一覧表示
  - 編集・削除ボタンの実装
- `src/main/resources/templates/posts/detail.html` - 投稿詳細画面（新規作成）
  - 投稿のタイトル・内容表示
  - 編集・削除ボタンの実装
- `src/main/resources/templates/posts/edit.html` - 投稿編集画面（新規作成）
  - 投稿編集フォームの実装
- `src/main/resources/templates/posts/new.html` - 新規投稿画面（修正）
  - 新規投稿フォームの実装
- `src/main/resources/templates/layout/layout.html` - 共通レイアウト（作成・修正）
  - Bootstrap 5.3.0 を使用した共通レイアウト
  - ヘッダー（ナビゲーションバー）の実装
  - フッターの実装

#### その他

- `README.md` - 起動コマンドの追加
- `index.html` - 追加（用途未確認）

### 備考

- 基本的な CRUD 機能が実装され、掲示板アプリとして動作可能な状態になりました
- Bootstrap を使用したレスポンシブな UI を実装
- Thymeleaf Layout Dialect を使用した共通レイアウトの実装

---

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
