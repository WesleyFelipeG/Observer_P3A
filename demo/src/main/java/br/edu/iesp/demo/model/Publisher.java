package br.edu.iesp.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements ISubscriber{
    private List<ISubscriber> subscribers = new ArrayList<>();
    private Produto mainState;

    public void subscribe(ISubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(Produto produto) {
        for (ISubscriber subscriber : subscribers) {
            subscriber.update(produto);
        }
    }

    @Override
    public void update(Produto produto) {
        mainState = produto;
        notifySubscribers(mainState);
    }

    public void listSubscribers() {
        for (ISubscriber subscriber : subscribers) {
            System.out.println(subscriber);
        }
    }
}
