/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blok;

import blok.interfaces.IPlugin;
import blok.interfaces.IPluginController;
import java.util.List;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class PluginController implements IPluginController {
    
    private List<IPlugin> pluginsFactory = new ArrayList();
    
    @Override
    public boolean initialize() {
        return true;
    }

    public void leituraPlugins() throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        File currentDir = new File("./plugins");
        String[] plugins = currentDir.list();
        int i;
        URL[] jars = new URL[plugins.length];
        for (i = 0; i < plugins.length; i++) {
            jars[i] = (new File("./plugins/" + plugins[i])).toURI().toURL();
        }

        URLClassLoader ulc = new URLClassLoader(jars); //responsável por carregar as classes via url's que estão dentro da variável jar.
        for (String x : plugins) {
            String factoryName = x.split("\\.")[0];

            //factoryName = jars[0].getFile().split("\\.")[1];
            IPlugin factory = (IPlugin) Class.forName(factoryName.toLowerCase() + "." + factoryName, true, ulc).newInstance();
            if (factory instanceof IPlugin) {
                pluginsFactory.add(factory);
            }
            System.out.println(factory.toString());
        }
    }

}
