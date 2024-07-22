import ea.Sound;

/**
 * Klasse SOUND kann MP3-Dateien abspielen
 *
 * @author mike ganshorn
 *
 * @version 2.0 (2017-04-11)
 *
 * @changelog 2.0 Umstieg von javaZoom auf Engine-Alpha-Sound
 */
public class SOUND extends Sound
{
    /**
     * Konstruktor der Klasse SOUND.
     *
     * @param datei Name der Datei (mit Endung) - muss im Projekt-Ordner liegen
     */
    public SOUND(String datei)
    {
        super(datei);
    }

    /**
     * Methode play.
     *
     */
    public void play()
    {
        super.play();
    }

    /**
     * Methode loop.
     *
     */
    public void loop()
    {
        super.loop();
    }

    /**
     * Methode pause.
     *
     */
    public void pause()
    {
        super.pause();
    }

    /**
     * Methode unpause.
     *
     */
    public void unpause()
    {
        super.unpause();
    }

    /**
     * Methode stop.
     *
     */
    public void stop()
    {
        super.stop();
    }
}
