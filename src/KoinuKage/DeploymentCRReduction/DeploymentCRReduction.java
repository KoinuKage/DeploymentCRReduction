package KoinuKage.DeploymentCRReduction;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import org.magiclib.util.MagicSettings;
import com.fs.starfarer.api.combat.ShipHullSpecAPI;

import static java.lang.Math.floor;

public class DeploymentCRReduction extends BaseModPlugin {
    float crReductionMultiplier = MagicSettings.getFloat("DeploymentCRReduction", "crReductionMultiplier");
    float suppliesRecoveryMultiplier = MagicSettings.getFloat("DeploymentCRReduction", "suppliesRecoveryMultiplier");

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
        if (((ship.getCRToDeploy() * crReductionMultiplier) <= 1) && (crReductionMultiplier > 0))
        {
            ship.setCRToDeploy(1);
            ship.setSuppliesToRecover(1);
        }
        else
        {
            ship.setCRToDeploy((float)floor(ship.getCRToDeploy() * crReductionMultiplier));
            ship.setSuppliesToRecover((float)floor(ship.getSuppliesToRecover() * (crReductionMultiplier * suppliesRecoveryMultiplier)));
        }
    }
}