package br.com.francivaldo;

import java.awt.Graphics;

public interface IGameManager<G> {
    public abstract void render(G g);
    public abstract void update();
}
