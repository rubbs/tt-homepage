#!/bin/bash

echo 'Player(name="Ruben Schwarz", email="schwarzruben@gmail.com"),
        Player(name="Thomas Gabel", email="thomas-gabel@gmx.net"),
        Player(name="Jan Reeß", email="jan-reess@t-online.de"),
        Player(name="Reinhard Böttinger", email="r.boettinger@outlook.de"),
        Player(name="Kathrin Szomolay", email="Kathi_Schulze@gmx.de"),
        Player(name="Christof Schwarz", email="christofschwarz62@gmx.de"),
        Player(name="Tilman Schwarz", email="tilman.schwarz@gmx.de"),
        Player(name="Clemens Böttinger", email="clemens-boettinger@arcor.de"),
        Player(name="Steffi Vetter", email="stefanie.vetter@t-online.de"),
        Player(name="Moritz Stumvoll", email="mstumvoll@web.de")
        ' | awk -F "\"" '{print "p.add(Player.builder().name(\""$2"\").email(\""$4"\").build());"}'
