# 一般的なEarの構成に則したサンプルプロジェクト

## ステートレスBeanとステートフルBeanの違い
### ステートレスBean
* インスタンスを使いまわす
* ∴インスタンスに状態を持たせると危険

### ステートフルBean
* EJBクライアント（※）ごとにインスタンスが異なる
* ∴インスタンスに状態を持たせれる

## トランザクションの範囲
### EJB内部
* コンテナでトランザクション管理される
* EJBをネストしても、最初のEJBがトランザクションの開始点となる

### EJB外部
* @Transactionalをメソッドに付与することで、そのメソッドがトランザクションの開始点となる</br>
　※Servletは@Transactionの効果がないので注意（クラス、メソッドともにNG）
* UserTransactionを使用すると、よりきめ細やかにユーザがトランザクションを制御できる（begin, commit, rollbackを自分で指定できるため）
* @TransactionalとUserTransactionは不可（トランザクションの割込み禁止）

### 補足機能
* war間でセッションを共有できるよう設定

# 参考
[JavaEEの使い方](https://qiita.com/opengl-8080/items/0dd004ea1d04cb50e39d)</br>
[EJB 2.1からEJB 3.0への移行](https://codezine.jp/article/detail/440)</br>
[gradle-java-ear](https://github.com/hammingweight/gradle-java-ear)</br>
[Eclipse-wtp ear with 3rd party libs](https://discuss.gradle.org/t/eclipse-wtp-ear-with-3rd-party-libs/20673)</br>
[JBoss 第7章 Web アプリケーションのクラスター化](https://access.redhat.com/documentation/ja-jp/red_hat_jboss_enterprise_application_platform/7.2/html/development_guide/class_loading_and_subdeployments)
