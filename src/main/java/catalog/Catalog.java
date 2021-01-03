package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    public double averagePageNumberOver(int over) {
        if (over <= 0) {
            throw new IllegalArgumentException("Page number must be positive");
        }

        double sum = 0;
        int numberOfOver = 0;
        for (CatalogItem catalogItem : catalogItems) {
            for (Feature feature : catalogItem.getFeatures()) {
                if (feature instanceof PrintedFeatures) {
                    int pageNumber = ((PrintedFeatures) feature).getNumberOfPages();
                    if (pageNumber > over) {
                        sum += pageNumber;
                        numberOfOver++;
                    }
                }
            }
        }
        if (numberOfOver == 0) {
            throw new IllegalArgumentException("No page");
        }
        return sum / numberOfOver;
    }

    public void deleteItemByRegistrationNumber(String regNumber) {
        List<CatalogItem> toDelete = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.getRegistrationNumber().equalsIgnoreCase(regNumber)) {
                toDelete.add(catalogItem);
            }
        }
        catalogItems.removeAll(toDelete);
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> result = null;
        if (searchCriteria.hasContributor() && searchCriteria.hasTitle()) {
            result = contributorAndTitle(searchCriteria.getContributor(), searchCriteria.getTitle());
        } else if (searchCriteria.hasContributor()) {
            result = onlyContributor(searchCriteria.getContributor());
        } else if (searchCriteria.hasTitle()) {
            result = onlyTitle(searchCriteria.getTitle());
        }
        return result;
    }

    private List<CatalogItem> onlyContributor(String contributor) {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            for (Feature feature : catalogItem.getFeatures()) {
                if (feature.getContributors().contains(contributor)) {
                    result.add(catalogItem);
                }
            }
        }
        return result;
    }

    private List<CatalogItem> onlyTitle(String title) {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            for (Feature feature : catalogItem.getFeatures()) {
                if (feature.getTitle().equalsIgnoreCase(title)) {
                    result.add(catalogItem);
                }
            }
        }
        return result;
    }

    private List<CatalogItem> contributorAndTitle(String contributor, String title) {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            for (Feature feature : catalogItem.getFeatures()) {
                if (feature.getTitle().equalsIgnoreCase(title) && feature.getContributors().contains(contributor)) {
                    result.add(catalogItem);
                }
            }
        }
        return result;
    }

    public int getAllPageNumber() {
        int sum = 0;
        for (CatalogItem catalogItem : catalogItems) {
            sum += catalogItem.numberOfPagesAtOneItem();
        }
        return sum;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasAudioFeature()) {
                result.add(catalogItem);
            }
        }
        return result;
    }

    public int getFullLength() {
        int sum = 0;
        for (CatalogItem catalogItem : catalogItems) {
            sum += catalogItem.fullLengthAtOneItem();
        }
        return sum;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasPrintedFeature()) {
                result.add(catalogItem);
            }
        }
        return result;
    }

}
