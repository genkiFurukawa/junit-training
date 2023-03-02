package unit.test.training.part1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("キッチンスケールクラスのテスト")
class KitchenScaleTest {
    @Nested
    @DisplayName("キッチンスケールの境界値のテスト")
    class キッチンスケールの境界値のテスト {
        @Test
        void 重さがマイナス1gの時に表示メッセージがEEEEとなること() {
            var kitchenScale= new KitchenScale(-1);
            assertEquals("EEEE", kitchenScale.getDisplayMessage());
        }

        @Test
        void 重さが0gの時に表示メッセージが0となること() {
            var kitchenScale= new KitchenScale(0);
            assertEquals("0", kitchenScale.getDisplayMessage());
        }

        @Test
        void 重さが2000gの時に表示メッセージが2000となること() {
            var kitchenScale= new KitchenScale(2000);
            assertEquals("2000", kitchenScale.getDisplayMessage());
        }

        @Test
        void 重さが2001gの時に表示メッセージがEEEEとなること() {
            var kitchenScale= new KitchenScale(2001);
            assertEquals("EEEE", kitchenScale.getDisplayMessage());
        }
    }

    @Nested
    @DisplayName("キッチンスケールの代表値のテスト")
    class キッチンスケールの代表値のテスト {
        @Test
        void 重さがマイナス1000gの時に表示メッセージがEEEEとなること() {
            var kitchenScale= new KitchenScale(-1000);
            assertEquals("EEEE", kitchenScale.getDisplayMessage());
        }

        @Test
        void 重さが1000gの時に表示メッセージが1000となること() {
            var kitchenScale= new KitchenScale(1000);
            assertEquals("1000", kitchenScale.getDisplayMessage());
        }

        @Test
        void 重さが3000gの時に表示メッセージが2000となること() {
            var kitchenScale= new KitchenScale(3000);
            assertEquals("EEEE", kitchenScale.getDisplayMessage());
        }
    }
}