# Vue.js + SpringBoot のサンプルSPAアプリ

## 全体アーキテクチャ

* SPAのファイルはSpringBootでホストして提供する構成とする

## フロントアプリ

Vueのサンプルアプリそのまま(vue create frontend-appで作成)
`frontend-app`配下に作成

### 環境

* Node12
* yarn (npmにしてもよいが今回はyarnを利用)
* Vue.js 2系
* Docker (ビルド環境を構築するのが大変なためコンテナ内でビルドする)

### ビルド実行コマンド

```
# コンテナ環境のビルド
docker build -t frontend-yarn ./frontend-build

# 依存ライブラリのインストール（= yarn install)
docker run -it --rm -v $(pwd)/frontend-app:/app frontend-build install

# ローカル実行(= yarn serve) http://localhost:8001 でアクセス可能
docker run -it --rm -v $(pwd)/frontend-app:/app -p 8001:8000 frontend-build serve

# ビルド(= yarn build)
docker run -it --rm -v $(pwd)/frontend-app:/app frontend-build build

# コンテナに入って手動でコマンドを叩く場合
docker run -it --rm -v $(pwd)/frontend-app:/app -v $(pwd)/backend/etc/openapi:/openapi --entrypoint="/bin/sh" frontend-build

# openapiのyamlからコードを生成する場合
docker run --rm -v $(pwd)/frontend-app:/app -v $(pwd)/backend/etc/openapi:/openapi openapitools/openapi-generator-cli generate \
     -g typescript-axios -i /openapi/apispec.yaml -o /app/src/openapi
```

---

## バックエンド

### 環境

* Java11
* SpringBoot2.2


### ビルド実行コマンド

```
cd backend

# フロントエンドのビルド成果物をコピー
rm -fr src/main/resources/static/ && cp -r ../frontend-app/dist/ src/main/resources/static

# ローカル起動 http://localhost:8002 
./gradlew clean bootRun

# jarファイル作成して jarをそのまま実行することも可能 http://localhost:8002
./gradlew clean build
java -jar build/libs/backend-0.1.0.jar
```
