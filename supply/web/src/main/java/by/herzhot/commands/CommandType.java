package by.herzhot.commands;

import by.herzhot.commands.impl.*;

/**
 * @author Herzhot
 * @version 1.0
 *          10.08.2016
 */
public enum CommandType {

    GOTOMAINPAGE, STARTSESSION, GOTOCATEGORYPAGE, DELETEMATERIAL,
    GOTOEDITMATERIALPAGE, EDITMATERIAL, FINDMATERIALS;

    public ICommand getCurrentCommand() {
        switch (this) {
            case STARTSESSION: return new StartSession();
            case GOTOMAINPAGE: return new GotoMainPage();
            case GOTOCATEGORYPAGE: return new GotoCategoryPage();
            case DELETEMATERIAL: return new DeleteMaterial();
            case GOTOEDITMATERIALPAGE: return new GotoEditMaterialPage();
            case EDITMATERIAL: return new EditMaterial();
            case FINDMATERIALS: return new FindMaterials();

            default: return new StartSession();
        }
    }
}
