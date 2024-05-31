# From MQTT to BigQuery データ変換パイプライン

## Prerequisites

To run this pipeline locally, you need the following:

- Java runtime (17 or later)
- Apache Maven (3.9.4 or later)

Also, You need one of the following to make the program recognize the authentication information for BigQuery:

- `gcloud auth application-default login` command to create and save authentication information for a user account with write permission to BigQuery as the application default authentication
- Place the key file of a service account with write permission to BigQuery on your local machine and pass the path to the GOOGLE_APPLICATION_CREDENTIALS environment variable

## How to execute

```
 $ mvn compile exec:java
```

You can see this code working and the data will be stored in BigQuery. However, if you switch the Java version to Java 21 by editing the pom.xml file and changing the Java version on your local machine, you will see a build failure.

## 前提条件

このパイプラインをローカルで動作させるためには、以下のものが必要となる。  

- Java runtime(17以降)
- Apache Maven(3.9.4以降)

また、BigQueryへのアクセス権限を持った認証情報をプログラムに認識させるため、以下のいずれかが必要。  

- gcloud auth application-default loginコマンドを用い、BigQueryに対して書き込み権限を持つユーザアカウントの認証情報をアプリケーションデフォルト認証として作成・保存する
- BigQueryに対して書き込み権限を持つサービスアカウントのキーファイルをローカルに配置し、GOOGLE_APPLICATION_CREDENTIALS環境変数にその配置パスを渡す


## 起動方法

```
 $ mvn compile exec:java
```

コードに変更を加えず上記コマンドを実行すると、ビルドに成功してデータが BigQuery に保存されることが確認できる。しかし、ローカルマシンの Java バージョンの切り替えと pom.xml ファイルの編集を行い Java のバージョンを21に変更すると、ビルドに失敗する。
