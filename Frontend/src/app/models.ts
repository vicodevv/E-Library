export interface Game{
    
    id: string;
    background_image: string;
    name: string;
    released: string;
    rating: number;
    ratings_count: number;
    metacritic: number;
    metacritic_url: string;
    genres: Array<Genre>;
    parent_platforms: Array<ParentPlatform>;
    publishers: Array<Publisher>;
    ratings: Array<Rating>;
    screenshots: Array<Screenshot>;
    trailers: Array<Trailer>;
}

export interface APIResponse<T> {
    results: Array<T>;
}

interface Genre {
    name: string;
}
interface ParentPlatform {
    platform: {
        name: string;
    }
}
interface Publisher {
    name: string;
}
interface Rating {
    id: number;
    count: number;
    title: string;
}
interface Screenshot {
    image: string;
}
interface Trailer {
    data: {
        max: string;
    }
}
