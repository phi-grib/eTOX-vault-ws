Description | Method | Parameters                  | URL example | Example respondes
------------ | -------------|-------------------------------------|-------|----------
Obtain the list of all models | /allmodels | authkey (security key) | http://phi.upf.edu/allmodels/?authkey=xxxxxxxxx | [allmodels](allmodels.md)
Obtain info for a model by modelid | /modelinfo | authkey (security key) <br> modelid (in URL) | http://phi.upf.edu/modelinfo/5000?authkey=xxxxxxxxx | [modelbyid](modelbyid.md)
Obtain info for a model by modeltag | /modelinfo | authkey (security key) <br> modeltag <br> provider (partner) | http://phi.upf.edu/modelinfo/?authkey=xxxxxxxxx&modeltag=/Toxicity/Organ%20Toxicity/Cardiotoxicity/QT%20Prolongation/1&provider=FIMIM | [modelbytab](modelbytag.md)
