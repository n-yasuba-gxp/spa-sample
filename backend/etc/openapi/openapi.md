# OpenAPIドキュメント


## バージョン情報

openapi3.0に従う

## ドキュメント・コード生成方法

[gradle-swagger-generator-plugin](https://github.com/int128/gradle-swagger-generator-plugin)を使う

ドキュメント生成　→　`build/swagger-ui-api` に出力
```
./gradlew generateSwaggerUI
```

コード生成 →　`build/swagger-code-api` に出力されたものをcontroller配下の該当ディレクトリにコピー・修正して使う
```
./gradlew generateSwaggerCode
```