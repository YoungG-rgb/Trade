import React from 'react';

const Features = () => {
    return (
        <div className='main_container'>
            <div className='w-full mt-[75px] mb-[125px]'>
                <h2 className='text-center not-italic font-normal text-[42px] leading-[25px] text-black'>Features</h2>
                <div className='flex justify-center relative'>
                    <div className='mb-[20px] text-right w-[200px] h-[250px] absolute top-[100px] left-[-35px]'>
                        <h2 className='not-italic font-medium text-[18px] leading-[12px] text-black'>Individual Style</h2>
                        <p className='not-italic font-normal text-[10px] leading-[24px] text-[#939393]'>48 style combinations <br/>
                            Color shifting Dial Colors <br/>
                            15 Strap options <br/>
                            Custom Strap Engraving</p>
                    </div>
                    <div className='w-[340px] h-[250px] absolute top-[180px] right-[-150px]'>
                        <h2 className='mb-[20px] not-italic font-medium text-[18px] leading-[12px] text-black'>Features</h2>
                        <p className='not-italic font-normal text-[10px] leading-[24px] text-[#939393]'>Case Size: 42mm <br/>
                            Case Color: Silver, Black, Blue, chamfered brush with mirror polish <br/>
                            Dial Color: Black Metallic, Color shifting Blue-Purple, Green-Purple, Pink-Gold <br/>
                            Water Resistance: 5 ATM/50 meters <br/>
                            Straps: Quick release <br/>
                            Movement: Swiss Parts RONDA 762E <br/>
                            Instantaneous rate -10/ +20 sec/month <br/>
                            Standard Battery life: 10 years</p>
                    </div>
                    <div className='text-right w-[300px] h-[190px] absolute bottom-[10px] left-[-80px]'>
                        <h2 className='mb-[20px] not-italic font-medium text-[18px] leading-[12px] text-black'>High Quality Components</h2>
                        <p className='not-italic font-normal text-[10px] leading-[24px] text-[#939393]'>Case: 316L Stainless-steel <br/>
                            Coating: Color anodized anti-scratch <br/>
                            Glass: Sapphire Crystal <br/>
                            Straps: 22mm Stainless-steel bracelet, Milanese Mesh bracelet, Leather</p>
                    </div>
                    <img className='' src="/main/imgFeatures.png" alt=""/>
                    <img className='absolute top-[110px] left-[187px]' src="/main/line1.svg" alt="line1"/>
                    <img className='absolute top-[190px] right-[214px]' src="/main/line2.svg" alt="line2"/>
                    <img className='absolute bottom-[140px] left-[255px]' src="/main/line3.svg" alt="line3"/>
                    <div className='absolute top-[104px] left-[180px] w-[14px] h-[14px] bg-[#735CFF] rounded-full'></div>
                    <div className='absolute top-[184px] right-[200px] w-[14px] h-[14px] bg-[#735CFF] rounded-full'></div>
                    <div className='absolute bottom-[134px] left-[245px] w-[14px] h-[14px] bg-[#735CFF] rounded-full'></div>
                </div>
            </div>
        </div>
    );
};

export default Features;