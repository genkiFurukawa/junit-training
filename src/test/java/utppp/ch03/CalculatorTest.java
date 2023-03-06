package utppp.ch03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    /**
     * AAAパターンでテストする
     */
    @Test
    void sum_of_two_numbers() {
        // Arrange(準備)フェーズ
        // NOTE: Arrangeフェーズが一番長くなるはず
        double first = 10;
        double second = 20;
        // NOTE: テスト対象システムと依存システムを分けるために変数名を工夫するテクニックもある。
        // テストの対象システムの変数名をsut(System of Unit Test)にする
        // このテストケースの場合は依存がないので、あまり効果がないが依存関係が多い場合はどのクラスをテストの対象にしているかわかりやすくなる
        var sut = new Calculator();

        // Act(実行)フェーズ
        // NOTE: 1行を越す場合は要注意
        double result = sut.sum(first, second);

        // Assert(確認)フェーズ
        // assert: to state firmly that something is true(英英の定義)
        // [memo] 実行結果とは戻り値のこともあれば、テスト対象システムやその協力者オブジェクトの実行後の状態のこともある
        // さらには協力者オブジェクトのメソッドが呼び出されたことが確認対象となることもある
        assertEquals(30, result);
    }
}