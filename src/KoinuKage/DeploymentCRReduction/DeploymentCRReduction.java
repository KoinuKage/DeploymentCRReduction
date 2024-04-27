package KoinuKage.DeploymentCRReduction;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import org.magiclib.util.MagicSettings;
import com.fs.starfarer.api.combat.ShipHullSpecAPI;

import java.util.Iterator;
import java.util.List;

public class DeploymentCRReduction extends BaseModPlugin {
    float crReductionMultiplier = MagicSettings.getFloat("DeploymentCRReduction", "crReductionMultiplier");

    public void ReduceDeploymentCR (ShipHullSpecAPI ship)
    {
        if (crReductionMultiplier < 0)
            crReductionMultiplier = 0;
        if (crReductionMultiplier > 100)
            crReductionMultiplier = 100;
        ship.setCRToDeploy(ship.getCRToDeploy() * crReductionMultiplier);
    }

    @Override
    public void onApplicationLoad() {


        for (Iterator iteration = Global.getSettings().getAllShipHullSpecs().iterator(); iteration.hasNext(); )
        {
            final ShipHullSpecAPI ship = (ShipHullSpecAPI) iteration.next();
            ReduceDeploymentCR(ship);
        }
    }
}
