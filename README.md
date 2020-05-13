# Vue.js + SpringBoot のサンプルSPAアプリ

## アーキテクチャ

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

# ローカル実行(= yarn serve) http://localhost:8000 でアクセス可能
docker run -it --rm -v $(pwd)/frontend-app:/app -p 8000:8000 frontend-build serve

# ビルド(= yarn build)
docker run -it --rm -v $(pwd)/frontend-app:/app frontend-build build

# コンテナに入って手動でコマンドを叩く場合
docker run -it --rm -v $(pwd)/frontend-app:/app --entrypoint="/bin/sh" frontend-build
```

## バックエンド

未
