The idea behind this mod is to reduce the cost of Deployment in CR for ships by a multiplier.
You can edit this multiplier in data\config\modSettings.json
You can use any value between 0-100 with decimals, if you use less than 0 mod will replace it with 0,
if you put anything over 100 it will replace it with 100.
Because deployment points are tied to the Suplies Recovery cost you may face an issue with massive fights (original combat size is 200-400 when the DP cost was between 7-60 or even more, right now with the default values it would be 1-5 or 1-6). To resolve that you have to manipulate the battlesize value in game settings.json file. Go to your starsector folder then "starsector-core\data\config" find the file settings.json, open it in notepad++ (or any text editor) and find the values "minBattleSize", "defaultBattleSize" and "maxBattleSize". My recommendation would be to change the values to the default value multiplied by the value that you have in crDeploymentMultiplier, after that you can leave it or increase it in case you want bigger fights.

Edit 30.04.2024
Be aware that CR is tied to ship price calculation, if you set it to 0 the ship prices will go to max integer values which is over 2 billion, for the lowest setting I would recommend between 0.05 and 0.1 as the prices will be still manageable.
Manipulating the CR deployment cost caused a massive increase in supply recovery cost which could destroy the fleet in a matter of days (example, if you reduced the CR deployment cost from 13 to 1 then the supply cost went up by around the difference)
Current calculation of supply recovery cost: Original cost multiplied by the CR Deployment multiplier multiplied by the supplies cost multipier (ex 12*0.1*0.8). I couldn't find a better way to resolve this issue right now.
Added a safety calculation, if you set the crDeploymentMultiplier to anything bigger than 0, if the calculation of the cost would be a value between 0 and 1, the mod will default to value 1, added it due to game bugging out and taking your supplies forever
