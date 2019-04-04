package Server.action;

import dto.ActionMessage;
import dto.HandleMessage;

public interface IAction {
	public HandleMessage handle(ActionMessage am);

}