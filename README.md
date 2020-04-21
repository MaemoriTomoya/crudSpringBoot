## 導入環境
①Java OpenJDK 12.0.1

②MySQL 8.0.17

## システム概要
Spring bootにて、spring jpaでmysqlに接続し、CRUD操作を行う。

## サービス内容（イメージ）
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

## 起動コマンド
下記の「docker-composeコマンド」を実行後、

#### docker-composeコマンド
| 概要 | コマンド |
| ------------- | ------------- |
| 作成・起動（バックグラウンド） | docker-compose up -d |
| 一覧表示 | docker-compose ps |
| 停止 | docker-compose down |
| 強制停止 | docker-compose kill |

#### dockerコマンド

> docker exec -it [docker-container-name] bash  
> 例）docker exec -it live_crud_database_1 bash

※Windowsの場合、エラーになる場合があります。  
　その場合、上記のコマンドの先頭に「winpty 」をつけて実行してみてください。

#### mysqlコマンド

> mysql -u root -p

※パスワードは「docker-compose.yml」の「MYSQL_ROOT_PASSWORD」を参照ください。

#### curlコマンド
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
