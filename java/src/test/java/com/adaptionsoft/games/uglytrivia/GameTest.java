package com.adaptionsoft.games.uglytrivia;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void addMethod_ShouldIncreasePlayersSize() throws Exception {
        Game test = new Game();
        test.add("wim");
        Assertions.assertThat(test.howManyPlayers()).isEqualTo(1);

        test.add("wilfried");
        Assertions.assertThat(test.howManyPlayers()).isEqualTo(2);
    }
}