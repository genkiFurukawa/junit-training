# ユニットテストの練習リポジトリ（JUnit）
## 背景
- 仕事でテストを書く文化がなく、テストを書かない => テストコードを書くスキルがつかない のループを繰り返している
- スキルを身につけるための勉強用のリポジトリ

## このリポジトリでやること
- [ソフトウェアテスト技法練習帳](https://gihyo.jp/book/2020/978-4-297-11061-1)をJunitを使いながら解く
  - テスト技法については[【この1冊でよくわかる】 ソフトウェアテストの教科書　［増補改訂 第２版］](https://www.sbcr.jp/product/4815608750/)を読みながら進める
- JUnitで色々書いてみて使い方を素振りする
- (optional)GitHub Actions でテストの自動実行と実行結果が見れるようにする

## 参考
- [assertSame](https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html#assertSame-java.lang.Object-java.lang.Object-)はオブジェクトの比較なので、文字列を比較するときはassertEqualsを使う