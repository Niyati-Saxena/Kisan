export default function ServiceCard({ number, icon, title, description }) {
  return (
    <div className="col-lg-3 col-md-6" style={ {border : '1px solid rgba(128 , 128 ,128 ,0.15)', backgroundColor : '#F4FCF2'
        }}>
      <div className="service-item">
        <span className="number">{number}</span>
        <div className="service-icon-wrapper">
  {icon}
</div>
        <div className="service-item-content">
          <h3 className="service-heading" style = {{paddingLeft : '15px'}}
          >{title}</h3>
          <p style = {{paddingLeft : '15px'}}>{description}</p>
        </div>
      </div>
    </div>
  );
}