package com.gatchasim.gatchasim.GatchaSystem;

import com.gatchasim.gatchasim.Database.ICommand;

import java.util.List;

public abstract class Banner {

    public abstract int GetPity(); // itt az osztály static fieldjét kell vissza adni majd

    public abstract int GetPullsSinceLast4Star();
    public abstract int GetPullsSinceLast5Star();

    public  abstract boolean IsOn5050(); // elvesztette e az utóbbbi fifty fiftyt

    protected ICommand get3starCommand;
    protected ICommand get4starCommand;
    protected ICommand get5starCommand;

    protected List<ThreeStarItem> threeStarItems; // itt majd adatbázisbó lekérés kell
    protected List<FourStarItem> fourStarItems; // itt majd adatbázisbó lekérés kell
    protected List<FiveStarItem> fiveStarItems; // itt majd adatbázisbó lekérés kell

    public ThreeStarItem ThreeStarPull(){
        return threeStarItems.getFirst();        // not final
    }

    public FourStarItem FourStarPull(){
        return fourStarItems.getFirst();              // not final
    }

    public FiveStarItem FiveStarPull(){
        return fiveStarItems.getFirst();            // not final
    }

}

// ebből származtatni a weaponm, main és base bannert mindegyikben pedig static field számol Pityt,
// így a main bannerek egymással megosztják, a weapon is a csak a weaponnal