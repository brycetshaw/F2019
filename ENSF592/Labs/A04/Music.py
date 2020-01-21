# MusicRoom module with Instruments
class MusicRoom:
    """Holding a list of instrument objects.

    Atrributes:
        instruments: List holding Instrument class objects.
    """

    def __init__(self, instruments):
        self.instruments = instruments

    def play(self, song):
        """Plays song on all instruments.

        song: string
        """
        # TODO: Add your code here
        for x in self.instruments:
            x.play(song)
            x.play_count += 1
        print('\n')

    def tune(self):
        """Tunes all instruments that are not currently tuned."""

        # TODO: Add your code here
        for x in self.instruments:
            if (x.detune_count is not x.detune_default):
                print('Tuning', x)
                x.detune_count = x.detune_default


class Instrument:
    """Parent class for instruments

    Atrributes:
        kind: string describing the type of instrument
        brand: string instrument maker/brand
        year: string year instrument was made
        is_tuned: bool, True if currently tuned, False otherwise
    """

    kind = 'Instrument'
    detune_count = 1
    detune_default = 1
    play_count = 0

    def __init__(self, brand, year):
        # TODO: Add your code here
        self.brand = brand
        self.year = year

    def __str__(self):
        """Human readable representation of the instrument."""
        # TODO: Add your code here
        return "a {} {} {}".format(self.year, self.brand, self.kind)

    def play(self, song):
        """plays song on instrument.

        Song will 'sound' different if instrument is not tuned.

        song: string

        returns: string representing song played
        """
        # TODO: Add your code here
        song = song.swapcase() if (self.detune_count is 0) else song
        return "{} plays: {} ".format(self.kind, song)


class Guitar(Instrument):
    """ A Guitar extends Instrument

    Instrument kind is 'Guitar'

    de-tunes after playing a song.
    """
    detune_default = 1
    detune_count = 1
    kind = 'Guitar'

    def play(self, song):
        """plays song and de-tunes.

        song: string
        returns: string representing song played
        """
        # TODO: Add your code here

        res = super().play(song)
        self.detune_count = 0
        print(res)


class Bass(Instrument):
    """ A Bass extends Instrument

    Instrument kind is 'Bass'

    de-tunes after playing two songs.

    Atrributes:
        detune_count: integer how many songs until de-tuned (default is 2)
        play_count: integer how many songs played
    """

    kind = 'Bass'
    detune_default = 2
    detune_count = 2

    def __init__(self, brand, year):
        super().__init__(brand, year)
        self.play_count = 0

    def play(self, song):
        """plays song and de-tunes if played detune_count songs.

        song: string
        returns: string representing song played
        """
        # TODO: Add your code here

        res = super().play(song)
        self.detune_count -= 1
        print(res)


class Drums(Instrument):
    """ Drums extends Instrument

    Instrument kind is 'Drums'

    Never de-tunes.
    """
    detune_count = 1
    kind = 'Drums'

    def play(self, song):
        """plays song like Instrument.

        song: string
        returns: string representing song played
        """
        res = super().play(song)
        print(res)


if __name__ == '__main__':
    # Create instances of Instruments
    my_instruments = [
        Bass("Ibanez", '2001'),
        Guitar("Fender", '1998'),
        Drums("Pearl", '2010')
    ]

    # Instantiate the MusicRoom class
    my_music_room = MusicRoom(my_instruments)

    # Rehearsing
    for i in range(3):
        my_music_room.play('Metallica - Nothing Else Matters')

    # Tune instruments
    my_music_room.tune()

    print("Done tuning\n")

    # Concert
