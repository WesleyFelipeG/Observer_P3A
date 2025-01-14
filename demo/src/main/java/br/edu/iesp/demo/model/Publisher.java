package br.edu.iesp.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    private final List<ISubscriber> subscribers = new ArrayList<>();

    public void subscribe(ISubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(Product product) {
        for (ISubscriber subscriber : subscribers) {
            subscriber.update(product);
        }
    }
}