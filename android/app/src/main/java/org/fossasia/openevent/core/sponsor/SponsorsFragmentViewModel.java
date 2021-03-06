package org.fossasia.openevent.core.sponsor;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import org.fossasia.openevent.data.Sponsor;
import org.fossasia.openevent.common.arch.LiveRealmData;
import org.fossasia.openevent.data.repository.RealmDataRepository;

import java.util.List;

public class SponsorsFragmentViewModel extends ViewModel {

    private LiveData<List<Sponsor>> sponsorsList;
    private RealmDataRepository realmRepo;

    public SponsorsFragmentViewModel() {
        realmRepo = RealmDataRepository.getDefaultInstance();
    }

    public LiveData<List<Sponsor>> getSponsors() {
        if (sponsorsList == null) {
            LiveRealmData<Sponsor> sponsorLiveRealmData = RealmDataRepository.asLiveData(realmRepo.getSponsors());
            sponsorsList = Transformations.map(sponsorLiveRealmData, input -> input);
        }
        return sponsorsList;
    }

}