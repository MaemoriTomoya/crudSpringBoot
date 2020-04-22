## 導入環境
①Java OpenJDK 12.0.1

②PostgreSQL 9.6

## システム概要
Spring bootにて、spring jpaでpostgresに接続し、CRUD操作を行う。

## サービス内容（イメージ）
配信サイト（ページ）のデータ扱いについて、以下の仕様のAPIとする。

| HTTPメソッド | URI | 内容 |
| ------------- | ------------- | ------------- |
| POST | /live | Liveデータを保存する |
| GET | /live | 全Liveデータを取得する |
| PUT | /live/{id} | 指定した id のLiveデータを更新する |
| DELETE | /live | 全Liveデータを削除する |
| DELETE | /live/{id} | 指定した id のLiveデータを削除する |

Liveデータについては、以下の内容とする。

| 項目名 | 型 | 説明 |
| ------------- | ------------- | ------------- |
| id | int | 固有ID |
| name | String | 名称 |
| url | String | URL |
| summary | String | 概要 |

## 起動 コマンド
下記の「docker-composeコマンド」を実行後、

#### docker-compose コマンド
| 概要 | コマンド |
| ------------- | ------------- |
| 作成・起動（バックグラウンド） | docker-compose up -d |
| 一覧表示 | docker-compose ps |
| 停止 | docker-compose down |
| 強制停止 | docker-compose kill |

#### docker コマンド
以下は、dockerにアクセスするコマンドです。

※Windowsの場合、下記のコマンドだとエラーになる場合があります。  
　その場合、先頭に「winpty 」をつけて実行してみてください。

> docker exec -it dbserver bash

#### PostgreSQL コマンド
以下のコマンドを用い、データの確認をすることができます。

| 概要 | コマンド |
| ------------- | ------------- |
| DB接続 | psql -p 5432 -U root -d cruddb |
| テーブル一覧表示 | \dt |
| データ確認 | select * from [テーブル名] |
| DB切断 | \q |

#### curl コマンド
下記のコマンドにてサーバへデータ転送を行い（apiを叩き）、動作を確認することが可能です。

①Liveデータを保存する
> curl -X POST -H 'Content-Type:application/json' -d '{"name":"名称", "url":"URL", "summary":"概要"}' localhost:8080/live

②全Liveデータを取得する
> curl -X GET -H 'Content-Type:application/json' localhost:8080/live

③指定した id のLiveデータを更新する
> curl -X PUT -H 'Content-Type:application/json' -d '{"name":"名称", "url":"URL", "summary":"概要"}' localhost:8080/live/{id}

④全Liveデータを削除する
> curl -X DELETE -H 'Content-Type:application/json' localhost:8080/live

⑤指定した id のLiveデータを削除する
> curl -X DELETE -H 'Content-Type:application/json' localhost:8080/live/{id}
