import "../styles/Grid.css";

const Grid = ({ data }) => (
  <section className="product-grid">
    <div className="grid">
      {data.map((p) => (
        <div key={p.ID} className="card">
          <div className="image-wrapper">
            {p.IMAGE_URL ? (
              <img src={p.IMAGE_URL} alt={p.NAME} />
            ) : (
              <div className="no-image">No Image</div>
            )}
          </div>
          <div className="info">
            <h3>{p.NAME}</h3>
            <p>{p.PRODUCER}</p>
          </div>
        </div>
      ))}
    </div>
  </section>
);

export default Grid;
