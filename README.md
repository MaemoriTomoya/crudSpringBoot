##導入環境
①Java OpenJDK 12.0.1

②MySQL 8.0.17

##システム概要
Spring bootにて、spring jpaでmysqlに接続し、CRUD操作を行う。

##サービス内容（イメージ）
配信サイト（ページ）のデータ扱いについて、以下の仕様のAPIとする。

| HTTPメソッド | URI | 内容 |
| ------------- | ------------- | ------------- |
| POST | /live | Liveデータを保存する |
| GET | /live | 全Liveデータを取得する |
| PUT | /live/{id} | 指定した id のLiveデータを更新する |
| DELETE | /live | 全Liveデータを削除する |
| DELETE | /live/{id} | 指定した id のLiveデータを削除する |

Liveデータについて、以下の内容とする。

| 項目名 | 型 | 説明 |
| ------------- | ------------- | ------------- |
| id | int | 固有ID |
| name | String | 名称 |
| url | String | URL |
| summary | String | 概要 |
