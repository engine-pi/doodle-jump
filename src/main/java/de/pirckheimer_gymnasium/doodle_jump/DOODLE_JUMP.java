package de.pirckheimer_gymnasium.doodle_jump;

/**
 * Beschreiben Sie hier die Klasse DOODLE_JUMP.
 *
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class DOODLE_JUMP extends SPIEL
{
    private DOODLER doodler;

    private PLATFORM[] platformen;

    private TEXT gameover_text;

    private SOUND gameover_sound;

    int punktestand;

    /**
     * Konstruktor für Objekte der Klasse DOODLE_JUMP
     */
    public DOODLE_JUMP()
    {
        super(532, 850, false, false, false);
        setzeHintergrundgrafik("images/background.png");
        doodler = new DOODLER();
        doodler.aktivMachen();
        platformen = new PLATFORM[10];
        for (int i = 0; i < platformen.length; i++)
        {
            int x_zufall = zufallszahlVonBis(50, 482);
            platformen[i] = new PLATFORM(x_zufall, 85 * (i + 1));
            platformen[i].neutralMachen();
        }
        punktestand = 0;
        setzeNurLinkePunkteanzeigeSichtbar();
        setzePunkteanzeigeLinks(punktestand);
        tickerNeuStarten(100);
    }

    /**
     * Wird bei jedem Tastendruck automatisch aufgerufen und automatisch das
     * Kuerzel der entsprechenden Taste mitgegeben.
     *
     * @param taste ganzzahliges Kuerzel der Taste (Farben_Tastencode.pdf) oder
     *              ENUM-Typ aus Klasse TASTE (darin die Klassen-Doku lesen)
     */
    @Override
    public void tasteReagieren(int taste)
    {
        switch (taste)
        {
        case TASTE.OBEN:
            doodler.sprung(10);
            break;

        case TASTE.LINKS:
            if (doodler.getX() > 0)
            {
                doodler.bewegen(-50, 0);
            }
            else
                doodler.setzeMittelpunkt(513, (int) doodler.getY());
            break;

        case TASTE.RECHTS:
            if (doodler.getX() < 532)
            {
                doodler.bewegen(50, 0);
            }
            else
                doodler.setzeMittelpunkt(20, (int) doodler.getY());
            break;
        }
    }

    /**
     * Wird regelmaessig automatisch aufgerufen. So kommt Bewegung ins Spiel!
     * Tick-Intervall kann angepasst werden. Ticker muss erst gestartet werden.
     */
    @Override
    public void tick()
    {
        if (istSpielVorbei())
        {
            tickerStoppen();
            gameover();
        }
        else
        {
            for (int i = 0; i < platformen.length; i++)
            {
                if (platformen[i].getY() < 850)
                {
                    platformen[i].bewegen(0, 5);
                    // Plattformen erst passiv machen, wenn sie "unterhalb" des
                    // Doodlers sind
                    if (platformen[i].getY() > doodler.getY())
                    {
                        platformen[i].passivMachen();
                    }
                    else
                        platformen[i].neutralMachen();
                }
                else
                {
                    int x_zufall = zufallszahlVonBis(50, 482);
                    platformen[i].setzeMittelpunkt(x_zufall, 0);
                }
            }
            aktualisierePunktestand();
        }
    }

    /**
     * Methode, die überprüft, ob das Spiel vorbei ist
     */
    public boolean istSpielVorbei()
    {
        if (doodler.getY() > 850)
        {
            return true;
        }
        else
            return false;
    }

    /**
     * Methode, die Text "Game over"!" anzeigt
     */
    public void gameover()
    {
        gameover_text = new TEXT(200, 425, "Game over!");
        gameover_text.setzeGroesse(50);
        gameover_text.setzeFarbe("Rot");
        gameover_sound = new SOUND("sounds/gameover.mp3");
        gameover_sound.play();
    }

    /**
     * Methode, die den Punktestand aktualisiert
     *
     * @param neuerPunktestand Neuer Punktestand
     */
    public void aktualisierePunktestand()
    {
        // Pro Tick wird der Punktestand um 10 erhöht
        punktestand = punktestand + 1;
        this.setzePunkteanzeigeLinks(punktestand);
    }
}
