package KoinuKage.DeploymentCRReduction;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import org.magiclib.util.MagicSettings;
import com.fs.starfarer.api.combat.CombatEngineAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.ShipHullSpecAPI;

import java.util.Iterator;
import java.util.List;

public class DeploymentCRReduction extends BaseModPlugin {
    float crReductionMultiplier = MagicSettings.getFloat("DeploymentCRReduction", "crReductionMultiplier");

    public void ReduceDeploymentCR (ShipHullSpecAPI ship)
    {
        if (crReductionMultiplier < 0)
            crReductionMultiplier = 0;
        ship.setCRToDeploy(ship.getCRToDeploy() * crReductionMultiplier);
    }

    @Override
    public void onNewGame() {

        final CombatEngineAPI engine = Global.getCombatEngine();
        if (engine == null || engine.isPaused()) return;

            for (Iterator iter = engine.getShips().iterator(); iter.hasNext(); )
            {
                final ShipHullSpecAPI ship = (ShipHullSpecAPI) iter.next();
                {
                    ReduceDeploymentCR(ship);
                }
            }
    }
}
