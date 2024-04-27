package KoinuKage.DeploymentCRReduction;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import org.magiclib.util.MagicSettings;
import com.fs.starfarer.api.combat.ShipHullSpecAPI;

public class DeploymentCRReduction extends BaseModPlugin {
    float crReductionMultiplier = MagicSettings.getFloat("DeploymentCRReduction", "crReductionMultiplier");

    @Override
    public void onApplicationLoad(){
        for (final ShipHullSpecAPI ship : Global.getSettings().getAllShipHullSpecs()) {
            ReduceDeploymentCR(ship);
        }
    }

    public void ReduceDeploymentCR (ShipHullSpecAPI ship)
    {
        if (crReductionMultiplier < 0) crReductionMultiplier = 0;
        if (crReductionMultiplier > 100) crReductionMultiplier = 100;
        ship.setCRToDeploy(ship.getCRToDeploy() * crReductionMultiplier);
    }
}