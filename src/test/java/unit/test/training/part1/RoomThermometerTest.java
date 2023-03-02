package unit.test.training.part1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ペット用の室温計クラスのテスト")
class RoomThermometerTest {
    @Nested
    @DisplayName("表示メッセージの境界値テスト")
    class 表示メッセージの境界値テスト {
        @Test
        void 室温が23_9度の時に寒いと表示されること() {
            var roomThermometer = new RoomThermometer((float) 23.9);
            assertEquals("寒い", roomThermometer.getDisplayMessage());
        }

        @Test
        void 室温が24_0度の時に快適と表示されること() {
            var roomThermometer = new RoomThermometer((float) 24.0);
            assertEquals("快適", roomThermometer.getDisplayMessage());
        }

        @Test
        void 室温が25_9度の時に快適と表示されること() {
            var roomThermometer = new RoomThermometer((float) 25.9);
            assertEquals("快適", roomThermometer.getDisplayMessage());
        }

        @Test
        void 室温が26_0度の時に快適と表示されること() {
            var roomThermometer = new RoomThermometer((float) 26.0);
            assertEquals("暑い", roomThermometer.getDisplayMessage());
        }
    }

    @Nested
    @DisplayName("表示メッセージの代表値のテスト")
    class 表示メッセージの代表値のテスト {
        @Test
        void 室温が23_0度の時に寒いと表示されること() {
            var roomThermometer = new RoomThermometer((float) 23.0);
            assertEquals("寒い", roomThermometer.getDisplayMessage());
        }

        @Test
        void 室温が25_0度の時に快適と表示されること() {
            var roomThermometer = new RoomThermometer((float) 25.0);
            assertEquals("快適", roomThermometer.getDisplayMessage());
        }

        @Test
        void 室温が27_0度の時に暑いと表示されること() {
            var roomThermometer = new RoomThermometer((float) 27.0);
            assertEquals("暑い", roomThermometer.getDisplayMessage());
        }
    }
}